using System.Net;
using System.Web;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Identity;

namespace Camunda.Helper
{
    public class uriParse
    {
        string _baseuri = "http://localhost:8080/engine-rest/";
        public static string uriCon(Dictionary<string,string> args, string ext)
        {
            var _baseuri = "http://localhost:8080/engine-rest/" + ext;
            

            var uri = Microsoft.AspNetCore.WebUtilities.QueryHelpers.AddQueryString(_baseuri, args);
            return  uri;
            
        }
    
    }
}
