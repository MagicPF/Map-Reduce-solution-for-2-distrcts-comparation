
    map function{
        split ":" into two part: district name and set of AQI
        split " " to get each AQI value
        Get District_name
        Get AQI and phrase into Integer
        if(Format and data is valid){
            Set Key with District name
            Set Int value of AQI
            Write into context
        }
    }

    reduce function{

      for(IntWritable val : values){
        switch (val){
            case val is 0 ~ 50: pollution += "Good "; break;
            case val is 51 ~ 100: pollution += "Moderate "; break;
            case val is 101 ~ 150: pollution += "Unhealthy for Sensitive Group "; break;
            case val is 151 ~ 200: pollution += "Unhealthy "; break;
            case val is 201 ~ 300: pollution += "Very Unhealthy "; break;
            case val is 300+ : pollution += "Hazardous "; break;
            default : pollution += "Invalid data "; break;
        }
      }
      Set the pollution string into result
      write into context
    }