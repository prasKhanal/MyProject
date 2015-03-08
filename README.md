# MyProject
<h1>Balanced	Brackets</h1>

Given a string consisting entirely of the characters ()[]{}, determine if it is "balanced". 

That is, every opening bracket must have a closing bracket of the same type following it, 

and the string in between the pair must also be balanced. For the purposes of the 

problem, an empty string should be considered balanced.

Input 1

()[]{}(([])){[()][]}

Output 1

balanced

Input 2

())[]{}

Output 2

not balanced

Input 3

[(])

Output 3

not balanced

CSV	Parsing

The input to this problem consists of a string of n comma-separated values, each value 

being an integer or a string. The required output is n consecutive lines, where line i

contains the ith value of the input.

NOTICE – string may contain commas (See Input 2 and 3 below).

Input 1

2,6,3,2,5

Output 1

(...CSV Parsing continued)

Input 2

"pears","apples","walnuts","grapes","cheese,cake"

Output 2

"pears"

"apples"

"walnuts"

"grapes"

"cheese,cake"

Input 3

1,"Que?","Kay?",2,"Si.","Sea? Kay, sea?","No, no, no. Que... 

‘what’.",234,"Kay Watt?","Si, que ‘what’.","C.K. 

Watt?",3,"Yes!","comma,comma, comma , :)"

Output 3

"Que?"

"Kay?"

"Si."

"Sea? Kay, sea?"

"No, no, no. Que... ‘what’."

234

"Kay Watt?"

"Si, que ‘what’."

"C.K. Watt?"

"Yes!"

"comma,comma, comma , :)"

Anagram Detection

You are given two strings, a ‘parent’ string and a ‘query’ string respectively. Your task is 

to determine how many times the query string – or an anagram of the query string –

appears in the parent string.

NOTE: There are a range of solutions to this problem. With a little thought, you can 

massively improve the efficiency of your solution. The optimal solution runs almost 

instantly even for extremely large (1 million+ characters) parent and query strings.

Input 1

AdnBndAndBdaBn

dAn

Output 1

Explanation 1

The substrings are highlighted below.

AdnBndAndBdaBn

AdnBndAndBdaBn

AdnBndAndBdaBn

AdnBndAndBdaBn
