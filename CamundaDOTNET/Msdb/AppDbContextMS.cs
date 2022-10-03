using Camunda.DTO;

using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;

namespace Camunda.Msdb
{
    public class AppDbContextMS : DbContext
    {
        public DbSet<UserDb> userDb { get; set; }

        public AppDbContextMS(DbContextOptions<AppDbContextMS> options) : base(options)
        {
               
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            
        }


    }
}
