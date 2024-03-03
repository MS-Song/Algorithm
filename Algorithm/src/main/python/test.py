print ("     *     ")
print ("    ***    ")
print ("   *****   ")
print ("  *******  ")
print (" ********* ")
print ("***********")
print ("    ***    ")
print ("    ***    ")
print ("    ***    ")

print ("------------")

blank_draw = " "
star_draw = "*"
max = 11

for i in range(1,max-1):
    star = i + (i-1)
    if(star > max):
        star = int(max/3)

    max_blank = max - star
    draw = ""
    for j in range(0,int(max_blank/2)):
        draw +=blank_draw
    for j in range(0,star):
        draw +=star_draw
    for j in range(0,int(max_blank/2)):
        draw +=blank_draw
    print(draw)
                
        
    
    




