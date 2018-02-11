const NUMBERS = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

const evaluateExpression = (expr) => {
    let precedence = {'-': 0, '+': 0, '*': 1, '/': 1};
    let operand = [], operator = [],
        result = parseInt(expr[expr.length - 1]),
        toEvaluate = expr.slice(0, expr.length - 2),
        i = 0;
    while (i < toEvaluate.length) {
        let elem = toEvaluate[i];
        if (isNaN(elem)) {
            if (operator.length === 0) {
                operator.push(elem);
            } else if (precedence[operator[operator.length - 1]] < precedence[elem]) {
                operator.push(elem);
            } else {
                let v1 = operand.pop(), v2= operand.pop();
                operand.push(eval(`${v2} ${operator.pop()} ${v1}`));
                operator.push(elem);
            }
        } else {
            operand.push(parseInt(elem));
        }
        i++;
    }
    while (operator.length > 0) {
        let v1 = operand.pop(), v2 = operand.pop();
        operand.push(eval(`${v2} ${operator.pop()} ${v1}`));
    }
    return result === operand.pop();
};


const getAllExpressions = (str) => {

    let numberOfOccurences = (str.match(/\?/g) || []).length,
        possibilities = new Array(numberOfOccurences).fill(NUMBERS),
        allCombinations = getAllCombinations(possibilities);
    return allCombinations.map(e =>
        Array.from(e.toString())
            .reduce((acc, value) => acc.replace('?', value), str));

};

const getCorrectExpression = (str) => {
    if (str.includes('?')) {
        let expressions = getAllExpressions(str);
        for (let i = 0; i < expressions.length; i++) {
            if (evaluateExpression(expressions[i].split(' '))) {
                return expressions[i];
            }
        }
    } else {
        return str;
    }
};

const getAllCombinations = (arr) => {
    return arr.reduce((acc, current) => {
        let temp = current.map(e => acc.map(x => `${x}${e}`));
        return [].concat.apply([], temp);
    }, arr.shift());
};


export {
    getAllCombinations,
    evaluateExpression,
    getAllExpressions,
    getCorrectExpression
};
