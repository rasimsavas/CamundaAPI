using Camunda.Model.Abstract;
using Newtonsoft.Json;

namespace Camunda.Model
{
    public class processInstance : RequestBase<processInstance>, IDTO<processInstance>
    {
        [JsonIgnore]
        public static string url { get; private set; } = "process-instance";
        public List<string> links { get; set; }
        public string id  { get; set; }
        public string definitionId { get; set; }
        public string businessKey { get; set; }
        public string caseInstanceId { get; set; }
        public bool ended { get; set; }
        public bool suspended  { get; set; }
        public string tenandId { get; set; }
    }
}
