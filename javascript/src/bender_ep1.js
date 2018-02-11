readline(); //ignore first readline
let map = [];

while (row = readline()) map.push(row.split(''));

const SOUTH = 'SOUTH', EAST = 'EAST', WEST = 'WEST', NORTH = 'NORTH';

const findElements = (matrix, char) => {
    let elems = [];
    for (let l = 0; l < matrix.length; l++) {
        for (let c = 0; c < matrix[0].length; c++) {
            if (matrix[l][c] === char) {
                elems.push({l: l, c: c});
            }
        }
    }
    return elems;
};

const nextPosition = (pos, dir) => {
    let l = pos.l, c = pos.c;
    switch(dir){
        case SOUTH: l++; break;
        case NORTH: l--; break;
        case EAST: c++; break;
        case WEST: c--; break;
    }
    return {l: l, c:c};
}

const getElem = (map, p) => map[p.l][p.c];

const nextDirection = (map, pos, current, directions, breaker) => {
    let dirs = directions.slice();
    dirs.unshift(current);

    return dirs.filter(d => {
        let elem = getElem(map, nextPosition(pos, d));
        return (elem !== '#' && elem !== 'X') || (breaker && elem === 'X');
    })[0];
};

const bender = (map) => {
    let directions = [SOUTH, EAST, NORTH, WEST],
        direction = SOUTH,
        breaker = false,
        dead = false,
        step = 0,
        path = [],
        [t1, t2] = findElements(map, 'T'),
        position = findElements(map, '@')[0];

    while (step < 1000 && !dead) {
        direction = nextDirection(map, position, direction, directions, breaker);
        path.push(direction);
        position = nextPosition(position, direction);
        let elem = getElem(map, position);
        switch (elem) {
            case '$': dead = true; break;
            case 'S': direction = SOUTH; break;
            case 'W': direction = WEST; break;
            case 'N': direction = NORTH; break;
            case 'E': direction = EAST; break;
            case 'B': breaker = !breaker; break;
            case 'I': directions = directions.reverse(); break;
            case 'X': map[position.l][position.c] = ' '; break;
            case 'T':
                position = (t1.l === position.l && t1.c === position.c) ? t2 : t1;
                break;
        }
        step++;
    }
    return {dead: dead, path: path};

};

let b = bender(map);
if(b.dead){
    b.path.forEach(n => print(n));
} else print('LOOP');