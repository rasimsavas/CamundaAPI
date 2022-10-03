using log4net;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Text.Json.Nodes;

namespace Camunda.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LogController : ControllerBase
    {
        private static readonly ILog _log = LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        public LogController()
        {
            
        }

        [HttpPost]
        public async Task<IActionResult> Logging([FromBody] JsonObject param)
        {

            var param2 = param.ToJsonString();
            _log.Info(param2);
           

            return NoContent();
        }
    }
}
