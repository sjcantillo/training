def rotateK(data):
        temp = data.split("\n")
        res = ""
        t = []
        ptemp = ""
        lont = 0
        nuCut = 0
        word = ""
        for i in range(0,int(temp[0])):
                t = temp[i+1].split(" ")
                nuCut = int(t[0])
                word = t[1]
                lont = len(word)
                res += word[nuCut:lont] + word[0:nuCut] + " "
        print(res)
