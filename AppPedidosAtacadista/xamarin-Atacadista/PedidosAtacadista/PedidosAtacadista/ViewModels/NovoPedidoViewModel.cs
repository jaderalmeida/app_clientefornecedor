using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using PedidosAtacadista.Models;
using PedidosAtacadista.ViewModels;
using Xamarin.Forms;

namespace PedidosAtacadista.ViewModels
{
    public class NovoPedidoViewModel
    {
        public NovoPedidoViewModel()
        {
            const string URL_POST_NOVOPEDIDO = "URL";

        public NovoPedido novopedido { get; set; }

        public Pedido pedido
        {
            get
            {
                return novopedido.pedido;
            }
            set
            {
                novopedido.pedido = value;
            }
        }

        public string Nome
        {
            get
            {
                return Pedido.Nome;
            }

            set
            {
                Pedido.Nome = value;
                OnPropertyChanged();
                ((Command)AgendarCommand).ChangeCanExecute();
            }
        }

        public string Fone
        {
            get
            {
                return Pedido.Fone;
            }

            set
            {
                Pedido.Fone = value;
                OnPropertyChanged();
                ((Command)AgendarCommand).ChangeCanExecute();
            }
        }
        public string Email
        {
            get
            {
                return Pedido.Email;
            }

            set
            {
                Pedido.Email = value;
                OnPropertyChanged();
                ((Command)AgendarCommand).ChangeCanExecute();
            }
        }

        public DateTime DataPedido
        {
            get
            {
                return Pedido.DataPedido;
            }
            set
            {
                Pedido.DataPedido = value;
            }
        }

        public TimeSpan HoraPedido
        {
            get
            {
                return Pedido.HoraPedido;
            }
            set
            {
                Pedido.HoraPedido = value;
            }
        }


        public NovoPedidoViewModel(Pedido pedido)
        {
            this.novopedido = new Pedido();
            this.novopedido.pedido = pedido;

            AgendarCommand = new Command(() =>
            {
                MessagingCenter.Send<Pedido>(this.pedido
                    , "Pedido");
            }, () =>
            {
                return !string.IsNullOrEmpty(this.Nome)
                     && !string.IsNullOrEmpty(this.Fone)
                     && !string.IsNullOrEmpty(this.Email);
            });
        }

        public ICommand AgendarCommand { get; set; }

        public async void SalvarNovoPedido()
        {
            HttpClient cliente = new HttpClient();

            var dataHoraNovoPedido = new DateTime(
                DataNovoPedido.Year, DataPedido.Month, DataPedido.Day,
                HoraNovoPedido.Hours, HoraPedido.Minutes, HoraPedido.Seconds);

            var json = JsonConvert.SerializeObject(new
            {
                nome = Nome,
                fone = Fone,
                email = Email,
                item = pedido.Nome,
                preco = pedido.Preco,
                dataPedido = dataHoraPedido
            });

            var conteudo = new StringContent(json, Encoding.UTF8, "application/json");

            var resposta = await cliente.PostAsync(URL_POST_NOVOPEDIDO, conteudo);
            if (resposta.IsSuccessStatusCode)
                MessagingCenter.Send<Pedido>(this.pedido, "SucessoPedido");
            else
                MessagingCenter.Send<ArgumentException>(new ArgumentException(), "FalhaNovoPedido");
        }


    }
    }
}
