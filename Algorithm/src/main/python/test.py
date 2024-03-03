# print ("     *     ")
# print ("    ***    ")
# print ("   *****   ")
# print ("  *******  ")
# print (" ********* ")
# print ("***********")
# print ("    ***    ")
# print ("    ***    ")
# print ("    ***    ")

for i in range(1,10):
    star = i + (i-1)
    if(star > 11):
        star = 3

    blank_draw = " "
    star_draw = "*"
    max = 11
    draw = ""
    for j in range(0,max):
        if star - j > 0:
            draw += star_draw
        else: 
            draw += blank_draw
    print(draw)
                
        
    
    




