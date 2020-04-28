
    map function{
        split ":" to get district name
        split " " to get each pollution level
      if(Format is OK){
        distKey.set(District);
        int intlevel;
        //phrase to integer level here:
        switch(level){
            case "Good": intlevel = 6;break;
            case "Moderate":intlevel = 5;break;
            case "Unhealthy for Sensitive Group":intlevel = 4;break;
            case "Unhealthy":intlevel = 3; break;
            case "Very Unhealthy":intlevel = 2;break;
            case "Hazardous": intlevel = 1; break;
            default:intlevel = -999; break;
        }
            Set Key with District name
            Set Int value of level
            Write into context
      }
    }


    reduce function{
        Strint Ans = "";
        for(IntWritable val : values){
            Get Value of Sham Shui Po as A
            Get Value of Kwun Tong as B
            difference = abs(A - B);
            switch(difference) {
                case 0:
                    Ans += "no discrepancy ";
                    break;
                case 1:
                    Ans += "discrepancies of 1 level ";
                    break;
                case 2 <= difference <= 7:Ans += "discrepancies of >=2 levels ";
                    break;
                default:
                    Ans += "either or both locations have invalid reading";
                    break;
            }
        }
        set the String answer into result
        write context
    }
