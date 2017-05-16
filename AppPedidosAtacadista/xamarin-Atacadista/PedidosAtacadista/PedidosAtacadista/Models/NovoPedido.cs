using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace PedidosAtacadista.Models
{
    public class NovoPedido
    {
        public Pedido pedido { get; set; }
        public string Nome { get; set; }
        public string Fone { get; set; }
        public string Email { get; set; }

        DateTime dataPedido = DateTime.Today;
        public DateTime DataPedido
        {
            get
            {
                return dataPedido;
            }
            set
            {
                dataPedido = value;
            }
        }

        public TimeSpan HoraPedido { get; set; }

    }
}
