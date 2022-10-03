using Microsoft.AspNetCore.Mvc;
using Camunda.Model;
using Newtonsoft.Json;

namespace Camunda.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CamundaController : ControllerBase
    {
        private static readonly HttpClient client = new HttpClient();
        private IConfiguration _Config;
        private readonly processDefinition _processDefinition;

        
        public CamundaController(IConfiguration Config)
        {
                
                _Config = Config;
        }
        [HttpGet]
        public async Task<IActionResult> Sas()
        {
            
            string uri = _Config.GetSection("baseUri").Value;

            var res =  client.GetAsync(uri+processDefinition.url);
            res.Wait();
            var result = res.Result;

                var readTask = result.Content.ReadAsStringAsync();
                readTask.Wait();
            
            List<processDefinition> definition = JsonConvert.DeserializeObject<List<processDefinition>>(readTask.Result);
        
            
            return Ok(definition);
        }

        [HttpPost]
        public async Task<IActionResult> pindex(int id)
        {
            return Ok(id);
        }

    }

}