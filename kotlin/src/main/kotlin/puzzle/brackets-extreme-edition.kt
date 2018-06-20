package puzzle

tailrec fun valid(exp: String, parentheses: Int = 0, accolades: Int = 0, hooks: Int = 0): Boolean =
        if (exp.isEmpty()) parentheses == 0 && accolades == 0 && hooks == 0
        else if (parentheses < 0 || accolades < 0 || hooks < 0) false
        else {
            val current = exp[0]
            valid(exp.substring(1),
                    parentheses + if (current == '(') 1 else if (current == ')') -1 else 0,
                    accolades + if (current == '{') 1 else if (current == '}') -1 else 0,
                    hooks + if (current == '[') 1 else if (current == ']') -1 else 0
            )
        }

