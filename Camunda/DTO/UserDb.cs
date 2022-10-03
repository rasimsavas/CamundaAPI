using System.ComponentModel.DataAnnotations;

namespace Camunda.DTO
{
    public class UserDb
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public string lastname { get; set; }
        public int TC { get; set; }
        public int password { get; set; }
        public int amount { get; set; }
        
    }
}
