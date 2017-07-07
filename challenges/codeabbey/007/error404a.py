"""This function convert degrees of Fahrenheit to Celsius"""


def fartocel(data):
    """Transform Fahrenheit to celcius"""
    temp = data.split(" ")
    cel = 0
    res = ""
    for i in range(0, int(temp[0])):
        cel = round(((int(temp[i+1]) - 32) * (5 / 9)))
        res += str(cel) + " "
    print res
