using Camunda.Model.Abstract;
using Newtonsoft.Json;

namespace Camunda.Model
{
    public class processDefinition : RequestBase<processDefinition>, IDTO<processDefinition>
    {
        
        [JsonIgnore]
        public static string url { get; private set; } = "process-definition";
        public string id{ get; set; }
        public string key { get; set; }
        public string category { get; set; }
        public string description { get; set; }
        public string name { get; set; }
        public int version { get; set; }
        public string resource { get; set; }
        public string deploymentId { get; set; }
        public string diagram { get; set; }
        public bool suspended { get; set; }
        public string tenandId { get; set; }
        public string versionTag { get; set; }
        public string historyTimeToLive { get; set; }
        public bool startableInTasklist { get; set; }
        
    }
    

}
