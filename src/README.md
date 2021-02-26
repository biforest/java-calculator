# Java-Calculator

Create a string calculator and write test code for it

## Contributor
- oereo

## Branch structure

### oereo branch
* from `oereo/java-calculator[oereo branch]` to `biforest/java-calculator [oereo branch]`

### java-calculator-structure branch
* Feature branch : Branch to develop the function ex)feature/java-calculator
* Fix branch : Branch to fix the function ex)fix/java-calculator

## TDD
### Failure case
#### (1) When divided by 0
```console
 연산을 입력해주세요 : 2/0  // error
```
#### (2) When two or more operation symbols appear in a row
```console
 연산을 입력해주세요 : 2++0  // error
```
#### (3) When the operation symbol appears at the beginning
```console
 연산을 입력해주세요 : +2+0  // error
```
#### (4) When special characters other than operation symbols are entered
```console
 연산을 입력해주세요 : 2^4  // error
```
#### (5) When characters excluding numbers and operators are entered
```console
 연산을 입력해주세요 : 2ㄱㄴ4*4  // error
```
#### (6) When the formula ends with an operation symbol
```console
 연산을 입력해주세요 : 2-1*  // error
```
## Structure
#### 1. Class
- Calculator class
  - `+ class`
  - `- class`
  - `* class`
  - `/ class`
- Input class
- Output class
  - `Error message` output
  - `Calculation result` output
- Error exception class
  - Precautions : only use `try ~ catch`
- Init class
  - When an error occurs, reset after outputting an error message
  - Reset and input when pressing any key value
    
#### 2. Algorithm
- DFS, Node