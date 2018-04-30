<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<div class="col-lg-9">
	<h1 style="padding: 0;#1784c7;font-family:san-serif;">Favorites</h1>
		<div class="table100 ver1 m-b-110">
		
			<div class="table100-head" style="text-align: center;">
				<table>
					<thead>
						<tr class="row100 head">
							<th class="cell100 column1">Rank</th>
							<th class="cell100 column2">Name</th>
							<th class="cell100 column3">Symbol</th>
							<th class="cell100 column4">Price USD</th>
							<th class="cell100 column5">% Change 1 hr</th>
							<th class="cell100 column6">% Change 24 hr</th>
						</tr>
					</thead>
				</table>
			</div>

			<div class="table100-body js-pscroll" id="fav-coins">
				<table>
					<tbody id="fav-coin-content">
						
					</tbody>
				</table>
			</div>
			
			
		</div>
	</div>
</div>