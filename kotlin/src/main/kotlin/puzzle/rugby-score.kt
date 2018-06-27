package puzzle


fun combinations(n:Int):List<Triple<Int,Int,Int>>{
    val r = mutableListOf<Triple<Int,Int,Int>>()
    for(a in 0..n/5){
        for(b in 0..n/7){
            for(c in 0..n/3){
                if(5*a+2*b+3*c == n && b<=a){
                    r.add(Triple(a,b,c))
                }
            }
        }
    }
    return r
}