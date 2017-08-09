package main
import (
    "fmt"
    "os"
    "log"
	"io/ioutil"
	"strconv"
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
		fmt.Println(getStringSubtition(lineString))
	}
}
func getStringSubtition(stringInitial string) string {
	splitLine := strings.Split(stringInitial, ";")
	if len(splitLine) > 1 {
		stringPrincipal := splitLine[0]
		stringList  := strings.Split(splitLine[1],",")
		if len(stringList) > 1 {
			return buildNewString(stringPrincipal,stringList)
		} else {
			return stringPrincipal
		}
	}
	return ""
}
func buildNewString(stringPrincipal string, stringList  []string) string {
	positionList := []string{}
	for i := 0 ; i < len(stringList); i = i +2 {
		validationFor := true
		indexInit := 0
		var substringIndex int
		for validationFor {
			substringIndex = indexInit + strings.Index(stringPrincipal[indexInit:len(stringPrincipal)],stringList[i])
			validationFor =validatePosition(positionList,int64(substringIndex))
			indexInit = substringIndex + len(stringList[i])
		}
		if substringIndex > -1	{
			diferenceSise :=  len(stringList[i + 1])	- len(stringList[i])
			if diferenceSise != 0 {
				positionList = changePostion(positionList,int64(substringIndex),int64(diferenceSise))
			}
			newPosition := strconv.Itoa(substringIndex)+"-"+strconv.Itoa((substringIndex - 1) + len(stringList[i + 1]))
			positionList = append(positionList,newPosition)
			stringPrincipal = stringPrincipal[0:substringIndex] +strings.Replace(stringPrincipal[substringIndex:len(stringPrincipal)],stringList[i],stringList[i + 1],1)
		}
	}
	return stringPrincipal
}
func changePostion(collection []string , currentPosition , diferencePosition int64) []string {
	nuevaCollection := collection[:0]
	for _,value := range collection {
		itemString := strings.Split(value,"-")
		min, err := strconv.ParseInt(itemString[0], 10, 64)
		if err != nil {
			log.Fatal(err)
		}
		max, err := strconv.ParseInt(itemString[1], 10, 64)
		if err != nil {
			log.Fatal(err)
		}
		if currentPosition < min {
			min = min + diferencePosition
			max = max + diferencePosition
			newPosition := strconv.Itoa(int(min))+"-"+strconv.Itoa(int(max))	
			nuevaCollection = append(nuevaCollection, newPosition)
		} else {
			nuevaCollection = append(nuevaCollection, value)
		}
	}
	return nuevaCollection
}
func validatePosition(collection []string, currentPosition int64) bool {
	if currentPosition == -1	{
		return false
	}
	countFind := 0
	for _,value := range collection {
		itemString := strings.Split(value,"-")
		min, err := strconv.ParseInt(itemString[0], 10, 64)
		if err != nil {
			log.Fatal(err)
		}
		max, err := strconv.ParseInt(itemString[1], 10, 64)
		if err != nil {
			log.Fatal(err)
		}
		if ((currentPosition >= min) && (currentPosition <= max)) {
			countFind++;
		}
	}
	if countFind == 0 {
		return false
	}
	return true
}
func main() {
    var filePath string
    fmt.Scan(&filePath)
    str :=validateFile(filePath)
    printStringSubtition(str)
}
