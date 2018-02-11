const BOTTOM = Symbol('BOTTOM'), RIGHT = Symbol('RIGHT'), LEFT = Symbol('LEFT'), TOP = Symbol('TOP'),
    DENIED = Symbol('DENIED');
const TYPES = {
    '0': {TOP: DENIED, LEFT: DENIED, RIGHT: DENIED},
    '1': {TOP: BOTTOM, LEFT: BOTTOM, RIGHT: BOTTOM},
    '2': {LEFT: RIGHT, RIGHT: LEFT},
    '3': {TOP: BOTTOM},
    '4': {TOP: LEFT, RIGHT: BOTTOM, LEFT: DENIED},
    '5': {LEFT: BOTTOM, RIGHT: DENIED, TOP: RIGHT},
    '6': {TOP: DENIED, LEFT: RIGHT, RIGHT: LEFT},
    '7': {TOP: BOTTOM, RIGHT: BOTTOM},
    '8': {RIGHT: BOTTOM, LEFT: BOTTOM},
    '9': {TOP: BOTTOM, LEFT: BOTTOM},
    '10': {TOP: LEFT, LEFT: DENIED},
    '11': {RIGHT: DENIED, TOP: RIGHT},
    '12': {RIGHT: BOTTOM},
    '13': {LEFT: BOTTOM}
};

const getPosition = (matrix, x, y, position) => {
    let room = matrix[y][x];
    let exit = TYPES[room][position];
    switch (exit) {
        case RIGHT:
            return {x: x + 1, y: y};
        case LEFT:
            return {x: x - 1, y: y};
        case BOTTOM:
            return {x: x, y: y - 1};
        default:
            return {x: x, y: y};
    }
};





