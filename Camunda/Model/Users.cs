using Camunda.Model.Abstract;
using Newtonsoft.Json;

namespace Camunda.Model
{
    public class Users : RequestBase<Users>, IDTO<Users>
    {
        [JsonIgnore]
        public static string url { get; set; } = "user";
        public UserProfile profile { get; set; }
        public UserCredentials credentials { get; set; }
    }
}
