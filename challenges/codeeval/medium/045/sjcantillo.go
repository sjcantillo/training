package main
import (
    "fmt"
    "os"
    "log"
	"io/ioutil" 
	"strconv"  
    "strings"
)
func validateFile(fileName string) string{
    file, err := os.Open(fileName)
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()
    b, err := ioutil.ReadAll(file)
    if err != nil {
        log.Fatal(err)
    }
    return string(b)
}
func printMagicNumber(numbers string){
    numberSplit := strings.Split(numbers, "\n")
    for item := range numberSplit {
		numberString := strings.Trim(strings.Trim(numberSplit[item], "\r")," ")
		numberItem, err := strconv.ParseInt(numberString, 10, 64)
		if err != nil {
            log.Fatal(err)
        }
		numberReverse, err := strconv.ParseInt(reverseString(numberString), 10, 64)
		if err != nil {
            log.Fatal(err)
		}
		numberPalindrome := numberItem + numberReverse;
		if validatePalindrome(strconv.FormatInt(numberPalindrome,10)) {
			lineNumber := strconv.FormatInt(int64(item + 1),10)
			numberPalin := strconv.FormatInt(numberPalindrome,10)
			fmt.Println(lineNumber+" "+numberPalin)
		}
	}
}
func validatePalindrome(number string) bool {
	if number == reverseString(number) {
		return true
	}
	return false
}
func reverseString(number string) (stringReserve string){
	for _, item := range number {
		stringReserve = string(item) + stringReserve
	}
	return stringReserve
}
func main() {
    var filePath string
    fmt.Scan(&filePath)
    str :=validateFile(filePath)
    printMagicNumber(str)
}
