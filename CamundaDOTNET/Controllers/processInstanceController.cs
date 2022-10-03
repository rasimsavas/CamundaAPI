using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Camunda.Model;
using Camunda.Helper;
using Newtonsoft.Json;
using System.Text;

namespace Camunda.Controllers
{
    [Route("api/processInstance")]
    [ApiController]
    public class processInstanceController : ControllerBase
    {
        private readonly HttpClient _client;
        public processInstanceController(HttpClient httpClient)
        {
            _client = httpClient;
        }
        [HttpGet]
        public async Task<IActionResult> GetPI()
        {
            var request = await _client.GetAsync(processInstance.url);
            var responce = await request.Content.ReadAsStringAsync();
            var result = jsonCon<processInstance>.getList(responce);
            return Ok(result);
        }
        [HttpPost]
        public async Task<IActionResult> GetPD(int firstResult, string maxResults)
        {
            var payload = new Dictionary<string, string>
            {
                ["firstResult"] = firstResult.ToString() ,
                ["maxResults"] = maxResults.ToString() 
            };
            string strobj = JsonConvert.SerializeObject(payload);
            HttpContent content = new StringContent(strobj, Encoding.UTF8, "application/json");
            string newuri = uriParse.uriCon(payload,processInstance.url);
            var request = _client.PostAsync(newuri, content);
            var result = await request.Result.Content.ReadAsStringAsync();
            List<processInstance> processInstances =  jsonCon<processInstance>.getList(result);
            return Ok(processInstances);
        }
        [HttpGet]
        [Route("count")]
        public async Task<IActionResult> Count()
        {
            var request = await _client.GetAsync(processInstance.url + "/count");
            var responce = await request.Content.ReadAsStringAsync();
            return Ok(responce);
        }
        [HttpPost]
        [Route("count")]
        public async Task<IActionResult> CountP()
        {
            var request = _client.PostAsync(processInstance.url + "/count",new StringContent("",Encoding.UTF8, "application/json"));
            var responce = await request.Result.Content.ReadAsStringAsync();

            return Ok(responce);
        }
    }
}
