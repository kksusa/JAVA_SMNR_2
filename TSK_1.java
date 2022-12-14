import java.util.HashMap;
import java.util.Map;

public class TSK_1
{
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("name","Ivanov");
        params.put("country","Russia");
        params.put("city","Moscow");
        params.put("age",null);
        System.out.println(getQuery(params));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder s = new StringBuilder();
        s.append("where ");
        for (Map.Entry<String,String> map : params.entrySet())
        {
            if (map.getValue() != null)
            {
                s.append(map.getKey() +" = " + map.getValue()+" and ");
            }
        }
        s.delete(s.toString().length()-5,s.toString().length());
        return s.toString();
    }

}