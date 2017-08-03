package main

import (
    "fmt"
    "strconv"
    "math"
)

func validateNumber(number int64,collection *[]int64) (int) {
    if number == 1{
        return 1
    } else {
        if   findNumber(number,collection) {
        	return 0
        }else{
        	*collection = append(*collection, number)
            powerSum := caculatedSumPower(number)
            return validateNumber(powerSum,collection)
        }
    }
}
func caculatedSumPower(number int64)(int64){
    numberString := strconv.Itoa(42)
    var powerSum int64 = 0
    for _, r := range numberString {
        itemString := string(r)
        numberItem, err := strconv.Atoi(itemString)
        if err == nil {
            powNumber := math.Pow(float64(numberItem), 2.0)
            powerSum =  powerSum + int64(powNumber)
        }
    }
    return powerSum
}
func findNumber(number int64,collection *[]int64)(bool){
    for _,v := range *collection {
        if v == number{
            return true
        }
    }
    return false
}

func main() {   
    colecctionSumPow := []int64{}
    var number int64
    fmt.Scan(&number)
    fmt.Println(validateNumber(number,&colecctionSumPow))
}
