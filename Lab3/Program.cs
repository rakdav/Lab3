using Lab3.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<DataContext>(opts =>
{
    opts.UseSqlServer(builder.Configuration[
        "ConnectionStrings:ProductConnection"]);
    opts.EnableSensitiveDataLogging(true);
});
var app = builder.Build();
app.UseMiddleware<Lab3.TestMiddleware>();
app.MapGet("/", () => "Hello World!");
var context = app.Services.CreateScope().ServiceProvider.
    GetRequiredService<DataContext>();
SeedData.SeedDatabase(context);
app.Run();
