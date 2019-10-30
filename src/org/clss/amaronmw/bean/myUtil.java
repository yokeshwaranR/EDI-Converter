/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.clss.amaronmw.bean;

import java.util.*;
import java.text.*;
/**
 *
 * @author ponraj.d
 */
public class myUtil {
   
    public String  ChangeDateFormat(String str_date) {


          StringTokenizer s=new StringTokenizer(str_date,"-");
          String year=s.nextToken();
          String mm=s.nextToken();
          String date=s.nextToken();
          String dat=date+"-"+mm+"-"+year;
         return dat;
    }
    public String formatSAPDate(String dat,String flag) {

        StringTokenizer xy = new StringTokenizer(dat, flag);
       
       
        String date = xy.nextToken();
        String month = xy.nextToken();
        String year = xy.nextToken();
        String retDate = year + month + date;
        return retDate.trim();
    }
     public String getSAPDate(String dat) {

        StringTokenizer xy = new StringTokenizer(dat, "-");
        String year = xy.nextToken();
        String month = xy.nextToken();
        String date = xy.nextToken();
        String retDate = year + month + date;
        return retDate.trim();
    }

     public String getFactoryDate(String dat) {

        StringTokenizer xy = new StringTokenizer(dat, "-");
        String date = xy.nextToken();
        String month = xy.nextToken();
        String year = xy.nextToken();
        
        
        String retDate = year + month + date;
        return retDate.trim();
    }
     public String getMySqlCurrentDate() {
         java.util.Date d = new java.util.Date();
         SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd");
         String dd = g.format(d);
         return dd;
     }
     public String getCurrentDate_slash() {
         java.util.Date d = new java.util.Date();
         SimpleDateFormat g = new SimpleDateFormat("dd/MM/yyyy");
         String dd = g.format(d);
         return dd;
     }
      public String getCurrentDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat g = new SimpleDateFormat("dd-MM-yyyy");
        String dd = g.format(d);
        return dd;
    }
      public String getCurrentYear() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat g = new SimpleDateFormat("yyyy");
        String dd = g.format(d);
        return dd;
    }
      public String getCurrentDateAsSAPformat() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat g = new SimpleDateFormat("yyyyMMdd");
        String dd = g.format(d);
        return dd;
    }

    
    public String fillZero(String line, int valid, int arraylength) {
        int numChar = 0;
        numChar = line.length();
        if (numChar > valid) {
            return "E";
        } else {
            int arraylen = arraylength;
            arraylen = arraylen - numChar;
            char fill[] = new char[arraylen];
//            Arrays.fill(fill, '0');
            String zeros = new String(fill);
            return zeros + line;
        }

    }
    public String fillZero(String line, int length) {
        int strlen =  line.length();
        String zeros = "";
        int loop_len=length-strlen;
        for (int i = 0; i < loop_len; i++) {
        zeros+="0";
        }
            return (zeros + line);
    }

    public String getCurrentFinancialMonth(String dd){
//        java.util.Date d = new java.util.Date();
//        System.out.println(d);
//        SimpleDateFormat g = new SimpleDateFormat("MM");
//        String dd = g.format(d);
        dd=getCurrentMonthFromdat(dd);
//        System.out.println(dd);
        if(dd.equals("01")){
            return "10";
        }else if(dd.equals("02")){
            return "11";
        }else if(dd.equals("03")){
            return "12";
        }else if(dd.equals("04")){
            return "1";
        }else if(dd.equals("05")){
            return "2";
        }else if(dd.equals("06")){
            return "3";
        }else if(dd.equals("07")){
            return "4";
        }else if(dd.equals("08")){
            return "5";
        }else if(dd.equals("09")){
            return "6";
        }else if(dd.equals("10")){
            return "7";
        }else if(dd.equals("11")){
            return "8";
        }else if(dd.equals("12")){
            return "9";
        }else {
            return "0";
        }

     }

    public boolean containsOnlyNumbers(String str) {

        //It can't contain only numbers if it's null or empty...
        if (str == null || str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++) {

            //If we find a non-digit character we return false.
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }

    public String removeZero(String str)
    {

        boolean result=containsOnlyNumbers(str);
        if(!result){
            return str;
        }else{
        String retStr=null;
        if(str.startsWith("0"))
        {
            int x=Integer.parseInt(str);
            retStr=""+x;
            return retStr;
        }
        else{
            return str;
        }
      }

    }

    // function for rounding
    public double Round(double Rval, int Rpl) {
        double p = (double) Math.pow(10, Rpl);
        Rval = Rval * p;
        double tmp = Math.round(Rval);
        return (double) tmp / p;
    }

    
    public String add_1day_Date(String datetxt) {
        String dateAfter = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date myDate = dateFormat.parse(datetxt);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            java.util.Date previousDate = calendar.getTime();
            dateAfter = dateFormat.format(previousDate);
        } catch (Exception e)
        {
            System.out.println(e);
            dateAfter = datetxt;
        }
        return dateAfter;
    }
    public String minus_1day_Date(String datetxt) {
        String dateAfter = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date myDate = dateFormat.parse(datetxt);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            java.util.Date previousDate = calendar.getTime();
            dateAfter = dateFormat.format(previousDate);
        } catch (Exception e)
        {
            System.out.println(e);
            dateAfter = datetxt;
        }
        return dateAfter;
    }

    public String getCurrentDateAsSAPdate(String dat){
          StringTokenizer xy = new StringTokenizer(dat, "-");
       
        
        String date = xy.nextToken();
        String month = xy.nextToken();
         String year = xy.nextToken();
        String retDate = year+"-"+ month+"-" + date;
        return retDate.trim();
    }

     public String previousDateAsSAPformat() {
        String cd=getCurrentDateAsSAPdate(getCurrentDate());
        String csap=getSAPDate(cd);
        String dateAfter = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            java.util.Date myDate = dateFormat.parse(csap);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            java.util.Date previousDate = calendar.getTime();
            dateAfter = dateFormat.format(previousDate);
        } catch (Exception e)
        {
            System.out.println(e);
            dateAfter = csap;
        }
        return dateAfter;
    }
    public String formatDate(String date,String from, String to)
    {
        try 
        {       
            SimpleDateFormat sdfSource = new SimpleDateFormat(from);
            java.util.Date dat = sdfSource.parse(date);
            SimpleDateFormat sdfDestination = new SimpleDateFormat(to);
            date = sdfDestination.format(dat);  
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return date;
    }
    public String removeLastTwoChar(String str){
         String ret=str.substring(0,str.length()-2);
         return ret;
     }
    
     public String getCurrentMonthFromdat(String dat) {

        String month=dat.substring(4,6);
        
        return month;
    }
     
     
     //PDA date validation
     public String getCurrentDate_ForValidation() {
         java.util.Date d = new java.util.Date();
         SimpleDateFormat g = new SimpleDateFormat("ddMMyyyy");
         String dd = g.format(d);

         return dd;
     }

//     public void checkValidateDate(String fromDate,String toDate) throws ParseException{
//     	String current_date=getCurrentDate_ForValidation();
//     	
//     	if(fromDate.isEmpty() && toDate.isEmpty()){
//     		fromDate=getCurrentDate_ForValidation();
//     		toDate=getCurrentDate_ForValidation();
//     		System.out.println("from date and to date correct");
//     	}
//     	
//     	else if(!fromDate.isEmpty() && toDate.isEmpty()){
//     			//toDate=getCurrentDate();
//     			if(!isValidDate(fromDate)){
//     				System.out.println("from date not a valid date!");
//     			}
//     			else if(!check_currentDate(fromDate,current_date)){
//     				System.out.println("from date should not be greater than today's date!");
//     			}
//     			else{
//     				toDate=getCurrentDate_ForValidation();
//     				System.out.println("from date"+fromDate+"=="+toDate);
//     				
//     			}
//     		
//     	}
////     	else if(fromDate.isEmpty() && !toDate.isEmpty()){
////     		System.out.println("from date should not be empty!");
//////     		if(!isValidDate(toDate)){
////// 				System.out.println("to Date not a valid date!");
////// 			}
//////     		else if(!check_currentDate(toDate,current_date)){
////// 				System.out.println("to Date should not be greater than current date!");
////// 			}else{
////// 				
////// 				
////// 			}
//// 		
////     	}
//     	else if(!fromDate.isEmpty() && !toDate.isEmpty()){
//     		if(!isValidDate(fromDate)){
// 				System.out.println("from Date not a valid date!");
// 			}
//     		else if(!isValidDate(toDate)){
// 				System.out.println("to Date not a valid date!");
// 			}
//     		else if(!check_currentDate(fromDate,current_date)){
// 				System.out.println("from Date should not be greater than today's date!");
// 			}
//     		else if(!check_currentDate(toDate,current_date)){
// 				System.out.println("to Date should not be greater than current date!");
// 			}
//     		else if(!check_currentDate(fromDate,toDate)){
// 				System.out.println("to Date should not be less than from date!");
// 			}
////     		else if(!check_currentDate(toDate,fromDate)){
//// 				System.out.println("to Date cannot be greater than from date!");
//// 			}
// 			else{
// 				System.out.println("from date and to date correct");
// 			}
// 		
//     	}
//     }
     
     

     public boolean isValidDate(String inDate) {

         if (inDate == null)
           return false;

         //set the format to use as a constructor argument
         SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
         
         if (inDate.trim().length() != dateFormat.toPattern().length())
           return false;

         dateFormat.setLenient(false);
         
         try {
           //parse the inDate parameter
           dateFormat.parse(inDate.trim());
         }
         catch (ParseException pe) {
           return false;
         }
         return true;
       }
     
     public boolean check_currentDate(String fromDate,String current_date) throws ParseException{
     	
     	SimpleDateFormat sdf = new SimpleDateFormat( "ddMMyyyy" );
 		java.util.Date d1 = sdf.parse( fromDate );
 		java.util.Date d2 = sdf.parse( current_date );
 		if ( compareTo( d1, d2 ) < 0 )
 		{
 		  return true;
 		}
 		else if ( compareTo( d1, d2 ) > 0 ) 
 		{
 		   return false;
 		}
 		else
 		{
 			return true;
 		}

 		
     }
     
     public static long compareTo( java.util.Date date1, java.util.Date date2 )
     {
     //returns negative value if date1 is before date2
     //returns 0 if dates are even
     //returns positive value if date1 is after date2
       return date1.getTime() - date2.getTime();
     }

     
     public static String trimLeadingZeros(String source)
	 {
	     for (int i = 0; i < source.length(); ++i)
	     {
	         char c = source.charAt(i);
	         if (c != '0' && !Character.isSpaceChar(c))
	             return source.substring(i);
	     }
	     return source;
	 }
     
    public static void main(String[] args) {
        myUtil my=new myUtil();
        String x=my.removeZero("");
        System.out.println(x);
    }
   
}
