import cv2
import sys
import numpy as np

def clahe(img, clip_limit = 2.0, grid_size = (8, 8)):
   clahe = cv2.createCLAHE(clipLimit = clip_limit, tileGridSize = grid_size)
   return clahe.apply(img)

img_src = "./images/dirtyrect.jpg"
img_pnt = "./images/dirtyrect_1.jpg"
img_out = "./images/dirtyrect_2.jpg"

src = cv2.imread(img_src)
src_width, src_height, _ = src.shape
if (src_width * src_height) < 50000:
   sys.exit(0)

# HSV thresholding to get rid of as much background as possible
hsv = cv2.cvtColor(src.copy(), cv2.COLOR_BGR2HSV)
lower_blue = np.array([0, 0, 120])
upper_blue = np.array([180, 38, 255])
mask = cv2.inRange(hsv, lower_blue, upper_blue)
result = cv2.bitwise_and(src, src, mask = mask)
b, g, r = cv2.split(result)
g = clahe(g, 5, (3, 3))

# Adaptive Thresholding to isolate the bed
img_blur = cv2.blur(g, (9, 9))
img_th = cv2.adaptiveThreshold(img_blur, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C,
   cv2.THRESH_BINARY, 51, 2)

#contours, hierarchy = cv2.findContours(img_th,
#   cv2.RETR_EXTERNAL,
#   cv2.CHAIN_APPROX_NONE)
contours, hierarchy = cv2.findContours(img_th,
   cv2.RETR_CCOMP,
   cv2.CHAIN_APPROX_SIMPLE)

first_size = 0
second_size = 0
first_approx = 0
second_approx = 0
min_rect = int((src_width * src_height) / 2)
canvas = src.copy()

# 전체 면적의 1/2 이상인 사각형들 중 가장 큰 것과 그 다음으로 큰 것을 추출
for cnt in contours:
   approx = cv2.approxPolyDP(cnt, cv2.arcLength(cnt, True) * 0.02, True)
   if len(approx) == 4:
      rect = cv2.boundingRect(cnt)
      x, y, w, h = rect
      if w * h > min_rect:
         mask = np.zeros(src.shape, np.uint8)
         mask[y: y + h, x: x + w] = src[y: y + h, x: x + w]
         size = np.sum(mask)
         if size > first_size:
            second_approx = first_approx
            first_approx = approx
            second_size = first_size
            first_size = size

# 검출된 사각형이 없으면 스킵
if first_size == 0:
   print("사각형 검출 실패")
   sys.exit(0)

#print(cv2.contourArea(first_approx))
#print(src_width * src_height)
#print(min_rect)
#print(cv2.contourArea(first_approx) / (src_width * src_height))

# 이미지 전체 면적의 99% 이상을 차지하는 사각형은 버리고, 그 다음으로 큰 사각형으로 작업한다
if (cv2.contourArea(first_approx) / (src_width * src_height)) > 0.99:
   first_approx = second_approx
   if second_size == 0:
      print("사각형 검출 실패")
      sys.exit(0)

# 검출된 사각형 그리기 (테스트 용 코드임. 주석처리 필요)
cv2.drawContours(canvas, [first_approx], -1, (0, 0, 255), 3)

# 검출된 사각형의 꼭지점 그리기 (테스트 용 코드임. 주석처리 필요)
for j in first_approx:
   cv2.circle(canvas, (int(j[0][0]), int(j[0][1])), 15, (255, 0, 0), -1)

# 검출된 사각형, 꼭지점 이미지 저장 (테스트 용 코드임. 주석처리 필요)
cv2.imwrite(img_pnt, canvas)

# 좌표 4개 배열 생성
pts = np.array([[first_approx[0][0][0], first_approx[0][0][1]],
                [first_approx[1][0][0], first_approx[1][0][1]],
                [first_approx[2][0][0], first_approx[2][0][1]],
                [first_approx[3][0][0], first_approx[3][0][1]]]).astype(np.float32)

# 좌표 4개 중 상하좌우 찾기 ---②
sm = pts.sum(axis=1)  # 4쌍의 좌표 각각 x+y 계산
diff = np.diff(pts, axis=1)  # 4쌍의 좌표 각각 x-y 계산

topLeft = pts[np.argmin(sm)]  # x+y가 가장 값이 좌상단 좌표
bottomRight = pts[np.argmax(sm)]  # x+y가 가장 큰 값이 우하단 좌표
topRight = pts[np.argmin(diff)]  # x-y가 가장 작은 것이 우상단 좌표
bottomLeft = pts[np.argmax(diff)]  # x-y가 가장 큰 값이 좌하단 좌표

# 변환 전 4개 좌표
pts1 = np.float32([topLeft, topRight, bottomRight, bottomLeft])

# 변환 후 영상에 사용할 서류의 폭과 높이 계산 ---③
w1 = abs(bottomRight[0] - bottomLeft[0])  # 상단 좌우 좌표간의 거리
w2 = abs(topRight[0] - topLeft[0])  # 하당 좌우 좌표간의 거리
h1 = abs(topRight[1] - bottomRight[1])  # 우측 상하 좌표간의 거리
h2 = abs(topLeft[1] - bottomLeft[1])  # 좌측 상하 좌표간의 거리
width = max([w1, w2])  # 두 좌우 거리간의 최대값이 서류의 폭
height = max([h1, h2])  # 두 상하 거리간의 최대값이 서류의 높이

# 변환 후 4개 좌표
pts2 = np.float32([[0, 0], [width - 1, 0],
                   [width - 1, height - 1], [0, height - 1]])

# 변환 행렬 계산
mtrx = cv2.getPerspectiveTransform(pts1, pts2)
# 원근 변환 적용
result = cv2.warpPerspective(src, mtrx, (int(width), int(height)))

# 그레이 변환
out = cv2.cvtColor(result,cv2.COLOR_BGR2GRAY)
#clahe = cv2.createCLAHE(clipLimit=2.0, tileGridSize=(16,16))
#cl1 = clahe.apply(out)
#out = bilFilter = cv2.bilateralFilter(cl1,9,20,20)

# 결과 이미지 저장
cv2.imwrite(img_out, out)