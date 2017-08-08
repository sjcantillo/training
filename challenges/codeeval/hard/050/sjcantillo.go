package main
import (
    "fmt"
    "os"
    "log"
	"io/ioutil"
    "strings"
)
func validateFile(fileName string) string {
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
func printStringSubtition(numbers string) {
    numberSplit := strings.Split(numbers, "\n")
    for item := range numberSplit {
		lineString := strings.Trim(strings.Trim(numberSplit[item], "\r")," ")
		getStringSubtition(lineString)
	}
}
func getStringSubtition(stringInitial string) string {
	splitLine := strings.Split(stringInitial, ";")	
	if len(splitLine) > 1 {
		stringPrincipal := splitLine[0]
		stringList  := strings.Split(splitLine[1],",")
		if len(stringList) > 1 {
			return buildNewString(stringPrincipal,stringList)
		}else {
			return stringPrincipal
		}
	}
	return ""
}
func buildNewString(stringPrincipal string, stringList  []string) string {
	for i := 0 ; i < len(stringList); i = i +2 {
		fmt.Println(stringList[i])
		fmt.Println(stringList[i + 1])
	}
	return ""
}
func main() {
    var filePath string
    fmt.Scan(&filePath)
    str :=validateFile(filePath)
    printStringSubtition(str)
}
