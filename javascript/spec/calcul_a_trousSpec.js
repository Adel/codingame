import {
    countUnknown, evaluateExpression, getAllCombinations, getAllExpressions, getCorrectExpression, getPossibleNumbers,
    handleOneUnknown
} from '../src/calcul_a_trous';

describe('Calcul à trous', () => {


    it('should evaluate expression', () => {
        expect(evaluateExpression(['2','+','8','=','10'])).toBe(true);
        expect(evaluateExpression(['2','+','8','-','4','=','6'])).toBe(true);
        expect(evaluateExpression(['2','+','8','*','2','=','18'])).toBe(true);
        expect(evaluateExpression(['2','+','8','-','2','=','0'])).toBe(false);
        expect(evaluateExpression(['88', '-','71','-','15','=','2'])).toBe(true);

    });

    it('should get all possible combinations', () => {
        expect(getAllCombinations([[0,1,2],[3,4,5]]).sort()).toEqual(['03','04','05','13','14','15','23','24','25'].sort());
        expect(getAllCombinations([[0,1,2],[3,4],[5,6,7]]).length).toEqual(18);
    });


    it('should get all expressions', () => {
        expect(getAllExpressions('8 + ? = 10').length).toEqual(10);
        expect(getAllExpressions('8 + ? - ? = 10').length).toEqual(100);

    });

    it('should get correct expression', () => {
        expect(getCorrectExpression('8 + ? = 10')).toEqual('8 + 2 = 10');
        expect(getCorrectExpression('8 - 2 = 6')).toEqual('8 - 2 = 6');
        expect(getCorrectExpression('8 / ? = 4')).toEqual('8 / 2 = 4');
        expect(getCorrectExpression('52? + 8 = 530')).toEqual('522 + 8 = 530');
        expect(getCorrectExpression('?? / 3 = 5')).toEqual('15 / 3 = 5');
        expect(getCorrectExpression('?8 - 71 - 1? = 2')).toEqual('88 - 71 - 15 = 2');


    });
});