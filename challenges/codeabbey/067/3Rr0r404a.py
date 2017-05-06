def IndexFoibonacci(data):
    """Calculate the index of foibonacci number."""
    t = data.split("\n")
    phi = (1 + math.sqrt(5)) / 2
    res = ""
    for k in range(0, int(t[0])):
        i = math.log(((int(t[k+1]) * math.sqrt(5)) + (1/2))) / math.log(phi)
        if i < 0:
            i = 0
            res = res + str(round((index))) + " "
    print res
