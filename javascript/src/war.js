let firstPlCards = [];
let sdPlCards = [];
var n = parseInt(readline()); // the number of cards for player 1
for (var i = 0; i < n; i++) {
    firstPlCards.push(readline().slice(0,-1));
}
var m = parseInt(readline()); // the number of cards for player 2
for (var i = 0; i < m; i++) {
    sdPlCards.push(readline().slice(0,-1));

}

const CARDS = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

const betterCard = (c1, c2) => CARDS.indexOf(c1) - CARDS.indexOf(c2);

const step = (tab1, tab2, step1, step2, it1, it2) => {
    if (step1.length === 0 && step2.length === 0){
        if (tab1.length === 0 && tab2.length >0){
            return `2 ${it2 + it1}`;
        } else if (tab2.length === 0 && tab1.length > 0){
            return `1 ${it1 + it2}`;
        }
    }
    let p1FirstCard = tab1.shift();
    let p2FirstCard = tab2.shift();
    step1.push(p1FirstCard);
    step2.push(p2FirstCard);

    let better = betterCard(p1FirstCard, p2FirstCard);
    if (better === 0) {
        if (tab1.length < 4 || tab2.length < 4) {
            return 'PAT';
        }
        tab1.splice(0, 3).forEach(n => step1.push(n));
        tab2.splice(0, 3).forEach(n => step2.push(n));
        return step(tab1, tab2, step1, step2, it1, it2);
    } else if (better > 0) {
        step1.concat(step2).forEach(n => tab1.push(n));
        return step(tab1, tab2, [], [], it1 + 1, it2);
    } else if (better < 0) {
        step1.concat(step2).forEach(n => tab2.push(n));
        return step(tab1, tab2, [], [], it1, it2 + 1);
    }
};

print(step(firstPlCards, sdPlCards, [], [], 0, 0));