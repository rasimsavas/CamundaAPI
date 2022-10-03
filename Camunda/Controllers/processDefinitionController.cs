using Camunda.Helper;
using Camunda.Model;
using Microsoft.AspNetCore.DataProtection.KeyManagement;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;

namespace Camunda.Controllers
{
    [Route("api/processDefinition")]
    [ApiController]
    public class processDefinitionController : ControllerBase
    {
        private readonly HttpClient _client;
        public processDefinitionController(HttpClient client)
        {
            _client = client;
        }

        [HttpGet]
        public async Task<IActionResult> GetPD()
        {
            var request = await _client.GetAsync(processDefinition.url);
            var result = await request.Content.ReadAsStringAsync();
            List<processDefinition> processDefinitions = jsonCon<processDefinition>.getList(result);

            return Ok(processDefinitions);
        }

        [HttpGet]
        [Route("count")]
        public async Task<IActionResult> DCount()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(_client.BaseAddress);
            sb.Append($"{processDefinition.url}/count");
            
            var request = await _client.GetAsync(sb.ToString());
            return Ok(request.Content.ReadAsStringAsync().Result);
        }

        [HttpDelete]
        [Route("key/{key}")]
        public async Task<IActionResult> DeleteProcess(string key)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(_client.BaseAddress);
            sb.Append($"{processDefinition.url}/key/{key}");
            var request = await _client.DeleteAsync(sb.ToString());
            return Ok(request.Content.ReadAsStringAsync().Result);
        }

        [HttpGet]
        [Route("key/{key}")]
        public async Task<IActionResult> GetProcessKey(string key)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(_client.BaseAddress);
            sb.Append($"{processDefinition.url}/key/{key}");
            var request = await _client.GetAsync(sb.ToString());
            return Ok(request.Content.ReadAsStringAsync().Result);
        }

    }
}
