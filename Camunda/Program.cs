using Camunda.Msdb;
using log4net.Config;
using Microsoft.AspNetCore.Mvc.Formatters;
using Microsoft.EntityFrameworkCore;
using System;
using System.Configuration;
using System.Net.Http.Headers;
using Microsoft.Extensions.Configuration;



var builder = WebApplication.CreateBuilder(args);


var config = new ConfigurationBuilder()
               .AddJsonFile("appsettings.json", false)
               .Build();
// Add services to the container.
HttpClient client = new HttpClient()
{

    BaseAddress = new Uri("http://localhost:8080/engine-rest/")
    
};
client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
builder.Services.AddControllers();

builder.Services.AddDbContext<AppDbContextMS>(options=>options.UseSqlServer(config.GetConnectionString("SqlCon")));

builder.Logging.AddLog4Net("log4net.config", true);
XmlConfigurator.Configure(new FileInfo("log4net.config"));
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddSingleton(client);




var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
