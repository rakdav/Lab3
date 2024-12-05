using Lab3.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ApplicationModels;
using Microsoft.AspNetCore.RateLimiting;

namespace Lab3.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    [EnableRateLimiting("fixedWindow")]
    public class ProductsController : ControllerBase
    {
        private DataContext db;

        public ProductsController(DataContext _db)
        {
            this.db = _db;
        }
        [HttpGet]
        public IAsyncEnumerable<Product> GetProducts()
        {
            return db.Products.AsAsyncEnumerable();
        }
        [HttpGet("{id}")]
        [DisableRateLimiting]
        public async Task<IActionResult> GetProduct(long id)
        {
            Product? p = await db.Products.FindAsync(id);
            if (p == null) return NotFound();
            return Ok(p);
        }
        [HttpPost]
        public async Task<IActionResult> SaveProduct([FromBody] Product product)
        {
            await db.Products.AddAsync(product);
            await db.SaveChangesAsync();
            return Ok(product);
        }
        [HttpPut]
        public async Task UpdateProduct(Product product)
        {
            db.Update(product);
            await db.SaveChangesAsync();
        }
        [HttpDelete("{id}")]
        public async Task DeleteProduct(long id)
        {
            db.Products.Remove(new Product()
            {
                ProductId=id,Name=string.Empty
            });
            await db.SaveChangesAsync();
        }
        [HttpGet("redirect")]
        public IActionResult Redirect()
        {
            return RedirectToAction(nameof(GetProduct),new {Id=1});
        }
    }
}
