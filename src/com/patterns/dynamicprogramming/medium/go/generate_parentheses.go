// Background and idea same as python file
package main

import (
	"fmt"
)

func main() {
	var result []string
	var closure string
	backtrack(&result, &closure, 0, 0, 3)
	fmt.Println(result)
}

func backtrack(result *[]string, closure *string, OpenNum, CloseNum, n int) {

	if OpenNum == CloseNum && OpenNum == n {
		*result = append(*result, *closure)
		return
	}

	if OpenNum < n {
		*closure += "("
		backtrack(result, closure, OpenNum+1, CloseNum, n)
		*closure = (*closure)[:len(*closure)-1]
	}

	if OpenNum > CloseNum {
		*closure += ")"
		backtrack(result, closure, OpenNum, CloseNum+1, n)
		*closure = (*closure)[:len(*closure)-1]
	}

}
