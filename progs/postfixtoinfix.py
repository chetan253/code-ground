def checkOp(expression):
	exp = (expression)
	if(expdict[exp] == '+' or expdict[exp] == '-' or expdict[exp] == '^'):
		return True
	else:
		return False
	
def checkOpRaise(expression):
	exp = (expression)
	if(expdict[exp] == '+' or expdict[exp] == '-' or expdict[exp] == '*' or expdict[exp] == '/' ):
		return True
	else:
		return False
		
'''def getHighestPrecedence(expression, operator):
	exp = (expression)
	if(expdict[exp] == '+' or expdict[exp] == '-') and (operator == '*' or operator == '/' or operator == '^')
		return operator
	elif(expdict[exp] == '*' or expdict[exp] == '/') and (operator == '^'):
		return operator
	else:
		return 0
'''
def check(expression):
	stack = []
	for elem in expression:
		if(elem == '(' or elem == ')' or elem == ' '):
			continue
		elif(elem == '+' or elem == '-'):
			elem2 = stack.pop()
			elem1 = stack.pop()
			exp = (elem1+elem+elem2)
			expdict[exp] = elem
			stack.append(exp)
			
		elif(elem == '*' or elem == '/'):
			elem2 = stack.pop()
			elem1 = stack.pop()
			elem1 = ['('+ elem1 +')' if checkOp(elem1) else elem1][0]
			elem2 = ['('+ elem2 +')' if checkOp(elem2) else elem2][0]
			exp = (elem1+elem+elem2)
			expdict[exp] = elem
			stack.append(exp)
		elif(elem == '^'):
			elem2 = stack.pop()
			elem1 = stack.pop()
			elem2 = ['('+elem2+')' if checkOpRaise(elem2) else elem2][0]
			elem1 = ['('+elem1+')' if checkOpRaise(elem1) else elem1][0]
			exp =(elem1+elem+elem2)
			expdict[exp] = elem
			stack.append(exp)
		else:
			expdict[elem] = ''
			stack.append(elem)
			
	print stack.pop()
	
expdict = {}	
check('ab+c*de-fg+*-')

