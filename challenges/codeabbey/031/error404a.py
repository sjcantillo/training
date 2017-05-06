"""This function cuts the n charsfrom the begining of string
and put it in the end.
input data:
2
3 forwhomthebelltolls
-6 verycomplexnumber"""


def rotatek(data):
    """Rotate n character to the end of string"""
    temp = data.split("\n")
    res = ""
    ltmp = []
    ptemp = ""
    lont = 0
    nuCut = 0
    word = ""
    for i in range(0, int(temp[0])):
        ltmp = temp[i+1].split(" ")
        nuCut = int(t[0])
        word = ltmp[1]
        lont = len(word)
        res += word[nuCut:lont] + word[0:nuCut] + " "
  print res
