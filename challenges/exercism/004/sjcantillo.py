def raindrops(number):
    divider = 2
    numberPrincipal = number
    raindropString = ""
    dictionary = {3 : "Pling", 5 : "Plang", 7 : "Plong"}
    while number !=  1:
        if number % divider == 0:
            number /= divider
        else:
            divider += 1
        if divider in dictionary:
            raindropString += dictionary[divider]    

    if len(raindropString) == 0:
        raindropString = str(numberPrincipal)
    
    return raindropString
var = int(input())      
print(raindrops(var))
