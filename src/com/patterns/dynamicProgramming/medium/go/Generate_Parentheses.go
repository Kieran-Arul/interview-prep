
// background and idea same as python file
package main

import (
	"fmt"

)
func main() {
	var result[] string
	var closure string
	backtrack(&result,&closure,0,0,3)
	fmt.Println(result)
}

func backtrack(result *[]string, closure *string,Open_num,Close_num, n int) {
	if Open_num == Close_num && Open_num == n {
		*result = append(*result,*closure)
		return
	}
	if Open_num < n {
		*closure += "("
		backtrack(result,closure,Open_num+1,Close_num,n)
		*closure = (*closure)[:len(*closure)-1]
	}
	if Open_num > Close_num {
		*closure += ")"
		backtrack(result,closure,Open_num,Close_num+1,n)
		*closure = (*closure)[:len(*closure)-1]
	}
}