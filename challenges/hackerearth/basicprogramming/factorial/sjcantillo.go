package main
import "fmt"
func factorial(number int64) int64 {
    var result int64
    if number < 2 {
        result = 1
    } else {
       result = number * factorial(number - 1)
    }
    return result
}
func main() {
    var number int64
    fmt.Scan(&number)
    if number > 0 {
        fmt.Println(factorial(number))
    }
}