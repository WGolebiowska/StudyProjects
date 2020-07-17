function addExpressions(expression1, expression2){

    var expression = expression1.concat(expression2);   //["2x^2", "3x^0"] + ["3x^3", "1x^2"] --> ["2x^2", "3x^0", "3x^3", "1x^2"]
    var expressionArray = [];   //["2x^2", "3x^0", "3x^3", "1x^2"] --> [[3, 3], [2, 2], [1, 2], [3, 0]] (splited by 'x^' and sorted by exponents decreasingly)
    var result = [];    //[[3, 3], [2, 2], [1, 2], [3, 0]] --> [[3, 3], [3, 2], [3,0]]
    
    expressionArray = expressionToExpressionArray(expression);
    
    /*
        Algorithm description:

            We need an array containing terms within subarrays, where the first element represents the coefficient and the second the exponent. The array must be sorted by the value of exponents decreasingly.

            If exponents of the two following terms are different, it means that the first one is the last of its exponent and it's copied to the result array.
            If exponents of the two following terms are the same, add the first one to the second and skip copying. The next term might be also of the same exponent.
            When you reach two different terms, where the first is the sum of all previous terms of the same exponent, copy it to the result array.

            The last term in expressionArray represents the sum of coefficients of the lowest exponent of the expression and it is copied to the result array explicitly.

            E.g.

            expressionArray                                 result
            [[3, 3], [2, 2], [1, 2], [3, 0]]                []
            
            [3, 3] != [2, 2]                                [[3, 3]]

            [2, 2] == [1, 2]    --> [2, 2] = [2+1, 2]       [[3, 3]]

            [3, 2] != [3, 0]                                [[3, 3], [3, 2]]

            []                                              [[3, 3], [3, 2], [3, 0]]


            To convert result array into expressionArray, you can use expressionArrayToExpression(expressionArray) function.
            To get a string representation of the whole expression from expressionArray, use getStringExpression().
    */

    for (var i = 0; i < expressionArray.length-1; i++) {
        if (expressionArray[i][1] == expressionArray[i+1][1]) {
            expressionArray[i+1][0] += expressionArray[i][0];
        } 
        
        else {
            result.push([expressionArray[i][0], expressionArray[i][1]]);
        }
    }
    
    result.push([expressionArray[expressionArray.length - 1][0], expressionArray[expressionArray.length - 1][1]]);            
    
    return result;
}


function expressionToExpressionArray(expression){   //["2x^2", "3x^0", "3x^3", "1x^2"] --> [[3, 3], [2, 2], [1, 2], [3, 0]] (split by 'x^' and sorted by exponents decreasingly)
    var expressionArray = [];
    for(var i = 0; i < expression.length; i++){
        var element = expression[i].split(/[\sx^]+/g);  //["3x^2"] --> ["3", "2"] (string)
        expressionArray.push([parseFloat(element[0]), parseFloat(element[1])]); //["3", "2"] --> [3, 2] (float)
    }
    
    expressionArray.sort(function(a, b){    //sorting by exponents decreasingly
        return b[1] - a[1];
    });
    
    return expressionArray;
}

function expressionArrayToExpression(expressionArray){  //[[3, 3], [2, 2], [1, 2], [3, 0]] --> ["3x^3", "2x^2", "1x^2", "3x^0"]
    var expression = [];
    for(var i = 0; i < expressionArray.length; i++){
        expression.push(expressionArray[i].join("x^"));
    }
  
    return expression;
}

function getStringExpression(expression){   //["3x^3", "2x^2", "1x^2", "3x^0"] --> "3x^3+2x^2+1x^2+3x^0"
    var stringExpression = "";
    for(var i = 0; i < expression.length - 1; i++){
        stringExpression += (expression[i] + "+");
    }
    stringExpression += expression[expression.length -1];
    
    return stringExpression;
}

//=========================ADDITIONAL TASK=============================

function stringExpressionToExpression(stringExpression){    //function for converting human readable mathematical expression to array of expressions
                                                            //"3x^3 + 2x^2 - x^4 + x^0.2 - 2x^(-5.1) + 4 - 3"    --> [[3x^3], [2x^2], [-1x^4], [1x^0.2], [-2x^-5.1], [4x^0], [-3x^0]] 
                                                            //It is not 100% complete and it looks pretty terrible, but my time is about to finish. It can be user for user input. :)
    var expression = [];
    var k = 0;
    var p = 0;

    for (var i = 0; i <= stringExpression.length; ++i) {
        expression[k] = stringExpression.substring(p, i);
        expression[k] = expression[k].replace(/[\s+()]/g, "");   

        if(!expression[k].includes("x")){
            expression[k] += "x^0";
        }
        else{
            if(expression[k].startsWith("x")){
                expression[k] = "1" + expression[k];
            }

            else{
                if(expression[k].startsWith("-x")){
                    expression[k] = expression[k].replace("-", "-1");
                }
            }

            if(expression[k].endsWith("x")){
                expression[k] += "^1";
            }

        }

        if ((stringExpression[i] == "+" || stringExpression[i] == "-") && stringExpression[i - 1] != "(") {
            k++;
            p = i;
        }
    }
    return expression;
} 
