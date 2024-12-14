using Lab3.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.RateLimiting;
using Microsoft.EntityFrameworkCore;

namespace Lab3.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    [Authorize]
    public class CategoriesController : Controller
    {
        private DataContext db;
        public CategoriesController(DataContext _db)
        {
            this.db = _db;
        }
        [HttpGet]
        public IAsyncEnumerable<Category> GetCategories()
        {
            return db.Categories.AsAsyncEnumerable();
        }
        [HttpGet("{id}")]
        public async Task<IActionResult?> GetCategory(long id)
        {
            Category? category = await db.Categories.
                FirstOrDefaultAsync(s => s.CategoryId == id);
            if (category != null)
            { 
                return Ok(category);
            }
            return NotFound();
        }
    }
}
