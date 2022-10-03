using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Camunda.Helper;
using Camunda.Model;
using Newtonsoft.Json;
using System.Text;
using System.Text.Json.Nodes;
using log4net;
using Camunda.Msdb;
using Camunda.DTO;
using Microsoft.EntityFrameworkCore;
using System.Linq;

namespace Camunda.Controllers
{   
    [Route("api/[controller]")]
    [ApiController]
    public class XJavaController : ControllerBase
    {
        //private readonly ILogger<XJavaController> _logger;
        private readonly AppDbContextMS _context;
        
        private static readonly ILog _log = LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);
        private readonly HttpClient _client;
        


        public XJavaController(HttpClient client, AppDbContextMS context)
        {
            _context = context;
            _client = client;
            //_logger = logger;
            
        }
        
        [HttpGet]
        public async Task<IActionResult> Res()
        {

            return Ok($"{_client.BaseAddress}"); //{ _logger.ToString()}");
        }
        [HttpPost]
        public async Task<IActionResult> GetValue([FromBody] JsonObject param)
        {

            
            int parampass = Int32.Parse(param.ElementAt(1).Value.ToString());
            int paramtc = Int32.Parse(param.ElementAt(0).Value.ToString());
            GlobalContext.Properties["PASSWORD"] = parampass;
            GlobalContext.Properties["TC"] = paramtc;
            var user = _context.userDb.FirstOrDefault<UserDb>(x => x.TC == paramtc && x.password == parampass);
            if (user != null)
            {
                _log.Info("giris yapildi..");
                return Ok();
            }


            //ThreadContext.Properties["ID"] = ID;


            _log.Info("giris basarisiz..");
            return BadRequest("kullanici adi veya sifresi yanlis..");
        }
        [Route("amount")]
        [HttpPost]
        public async Task<IActionResult> CheckAmount([FromBody] JsonObject param)
        {
            int paramtc = Int32.Parse(param.ElementAt(0).Value.ToString());
            int paramamount = Int32.Parse(param.ElementAt(1).Value.ToString());
            GlobalContext.Properties["TC"] = paramtc;
            GlobalContext.Properties["AMOUNT"] = paramamount;
            

            var user = _context.userDb.FirstOrDefault<UserDb>(x => x.TC == paramtc);
            if(user.amount > paramamount)
            {
                user.amount = user.amount - (int)paramamount;
                await _context.SaveChangesAsync();
                _log.Info("cekim islemi yapildi..");
                return Ok();
            }
            _log.Info("bakiyeniz yetersiz..");
            return BadRequest("bakiyeniz yetersiz..");
        }
        [HttpPost]
        [Route("deposit")]
        public async Task<IActionResult> Deposit([FromBody] JsonObject param)
        {
            int deposit = Int32.Parse(param.ElementAt(0).Value.ToString());
            int TC = Int32.Parse(param.ElementAt(1).Value.ToString());

            var user = _context.userDb.FirstOrDefault(x => x.TC == TC);
            if (user != null)
            {
                user.amount += deposit;
                await _context.SaveChangesAsync();
                return Ok();
            }

            return BadRequest();
   
        }
    }
    
    
}
