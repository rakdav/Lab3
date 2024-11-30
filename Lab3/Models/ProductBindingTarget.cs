using System.ComponentModel.DataAnnotations;

namespace Lab3.Models
{
    public class ProductBindingTarget
    {
        [Required]
        public required string Name { get; set; }
        [Range(1,1000000)]
        public decimal Price { get; set; }
        [Range(1, long.MaxValue)]
        public long GategoryId{ get; set; }
        [Range(1, long.MaxValue)]
        public long SupllierId { get; set; }
        public Product ToProduct() => new Product()
        {
            Name=this.Name,Price=this.Price,
            CategoryId=this.GategoryId, SupplierId=this.SupllierId
        };
    }
}
