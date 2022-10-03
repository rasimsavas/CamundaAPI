using Newtonsoft.Json;
using System.Text.Json.Nodes;
using log4net;

namespace Camunda.Helper
{
    public class jsonCon<DTO> where DTO : class
    {
        
        
        public jsonCon()
        {

        }

        public static List<DTO> getList(string json)
        {   
            var result = JsonConvert.DeserializeObject<List<DTO>>(json);
            return result;
        }
        public static DTO Single(string obj)
        {
            var result = JsonConvert.DeserializeObject<DTO>((string)obj);
            return result;
        }
        
    }
}
