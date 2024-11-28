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
        public async Task<IActionResult> SaveProduct(Product )
    }
}
