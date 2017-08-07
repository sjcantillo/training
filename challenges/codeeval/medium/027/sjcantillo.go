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
func printConvertBinary(numbers string){
    numberSplit := strings.Split(numbers, "\n")
    for item := range numberSplit {
        numberString := strings.Trim(numberSplit[item], "\r")
        numberItem, err := strconv.ParseInt(numberString, 10, 64)
        if err != nil {
            log.Fatal(err)
        }
        numberBinary := strconv.FormatInt(numberItem, 2)
        fmt.Println(numberBinary)
    }
}
func main() {
    var filePath string
    fmt.Scan(&filePath)
    str :=validateFile(filePath)
    printConvertBinary(str)
}
