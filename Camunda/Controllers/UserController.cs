using Camunda.Helper;
using Camunda.Model;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Text;


namespace Camunda.Controllers
{
    
    [Route("api/User")]
    [ApiController]
    public class UserController : ControllerBase
    {
        
        private readonly HttpClient _client;
        private readonly ILogger<UserController> _logger;

        public UserController(HttpClient client, ILogger<UserController> logger)
        {
            _client = client;
            _logger = logger;
            
        }
        [HttpGet]
        public async Task<IActionResult> GetUserProfile()
        {
            var asd = HttpContext.Items.ToString();
            
            
            

            var request = await _client.GetAsync(Users.url);
            var responce = await request.Content.ReadAsStringAsync();
            var result = jsonCon<UserProfile>.getList(responce);
            return Ok(result);
        }
       
        [HttpGet]
        [Route("count")]
        public async Task<IActionResult> Count()
        {
            var request = await _client.GetAsync(Users.url + "/count");
            var responce = await request.Content.ReadAsStringAsync();
            return Ok(responce);
        }

        [HttpPost]
        [Route("create")]
        public async Task<IActionResult> Create([FromBody] Users user)
        {

            string strUser = JsonConvert.SerializeObject(new Users { profile = user.profile, credentials = user.credentials });
            HttpContent message = new StringContent(strUser, Encoding.UTF8, "application/json");            
            await _client.PostAsync(Users.url + "/create", message);
            
            return Ok(user);
        }

        [HttpDelete]
        [Route("{id}")]
        public async Task<IActionResult> DeleteUser(string id)
        {
            await _client.DeleteAsync(Users.url + "/" + id);

            return NoContent();
        }

        [HttpPut]
        [Route("{id}/credentials")]
        public async Task<IActionResult> UpdateCredential([FromBody] UserCredentials credential, string id)
        {   

            string credentails = JsonConvert.SerializeObject(new UserCredentials 
                                { authenticatedUserPassword = credential.authenticatedUserPassword,
                                  password = credential.password});
            HttpContent content = new StringContent(credentails, Encoding.UTF8, "application/json");
            var request = await _client.PutAsync(Users.url + "/"+id + "/credentials", content);

            return Ok(request);
        }
        [HttpGet]
        [Route("{id}/profile")]
        public async Task<IActionResult> GetProfile(string id)
        {
            StringBuilder url = new StringBuilder();
            url.Append(_client.BaseAddress.ToString());
            url.Append($"{Users.url}/{id}/profile");
            var request = await _client.GetAsync(url.ToString());
            var response =  request.Content.ReadAsStringAsync().Result;
            UserProfile userprofile = JsonConvert.DeserializeObject<UserProfile>(response);
            
            return Ok(userprofile);
        }
        [HttpPut]
        [Route("{id}/profile")]
        public async Task<IActionResult> UpdateProfile([FromBody] UserProfile userprofile, string id)
        {
            StringBuilder url = new StringBuilder();
            url.Append(_client.BaseAddress.ToString());
            url.Append($"{Users.url}/{id}/profile");

            string profile = JsonConvert.SerializeObject(userprofile);
            HttpContent content = new StringContent(profile, Encoding.UTF8, "application/json");
            var request = await _client.PutAsync(url.ToString(), content);
            

            return Ok();
        }
        [HttpPost]
        [Route("{id}/unlock")]
        public async Task<IActionResult> Unlock(string id)
        {
            StringBuilder url = new StringBuilder(_client.BaseAddress.ToString());
            url.Append($"{Users.url}/{id}/unlock");
            await _client.PostAsync(url.ToString(), new StringContent(id));
            return Ok();

        }
    }
}
