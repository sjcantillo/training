def raindrops(number):
    divider = 2
    number_principal = number
    raindrop_string = ""
    dictionary = {3: "Pling", 5: "Plang", 7: "Plong"}
    while number != 1:
        if number % divider == 0:
            number /= divider
        else:
            divider += 1
        if divider in dictionary:
            raindrop_string += dictionary[divider]
    if len(raindrop_string) == 0:
        raindrop_string = str(number_principal)
    return raindrop_string


number_input = int(input())
print(raindrops(number_input))
